<template>
    <v-container>
      <v-card v-if="table" class="pa-4">
        <v-card-title>{{ table.description }}</v-card-title>
        <v-card-subtitle>ID: {{ table.id }}</v-card-subtitle>
        <v-card-text>
          <p><strong>Chave Primária:</strong> {{ table.primaryKey }}</p>
        </v-card-text>
        
        <!-- v-tabs para alternar entre as abas -->
        <v-tabs v-model="activeTab" >
          <v-tab value="fields" v-tab prepend-icon="mdi-table">Campos</v-tab>
          <v-tab value="indexes" v-tab prepend-icon="mdi-table-headers-eye">Índices</v-tab>
        </v-tabs>
  
        <v-window v-model="activeTab">
          <v-window-item value="fields">
            <TableFields :tableId="table.id" />
          </v-window-item>
          
          <v-window-item value="indexes">
            <TableIndexes :tableId="table.id" />
          </v-window-item>
        </v-window>
        
      </v-card>
      <v-alert v-else type="error">Tabela não encontrada.</v-alert>
    </v-container>
  </template>
  
  <script>
  import { ref, onMounted } from 'vue';
  import { useRoute } from 'vue-router';
  import tableService from '@/services/tableService';
  import TableFields from '@/components/TableFields.vue';
  import TableIndexes from '@/components/TableIndexes.vue';
  
  export default {
    components: { TableFields, TableIndexes },
    setup() {
      const table = ref(null);
      const activeTab = ref("fields");
      const route = useRoute();
  
      onMounted(async () => {
        try {
          const tableId = route.params.tableId;
          table.value = await tableService.getTableById(tableId);
        } catch (error) {
          console.error('Erro ao carregar os detalhes da tabela:', error);
          this.$emit('error', error);
        }
      });
  
      return { table, activeTab };
    }
  };
  </script>
  