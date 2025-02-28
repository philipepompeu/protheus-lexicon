<template>
    <v-container>
      <v-card v-if="table" class="pa-4">
        <v-card-title>{{ table.description }}</v-card-title>
        <v-card-subtitle>ID: {{ table.id }}</v-card-subtitle>
        <v-card-text>
          <p><strong>Chave Primária:</strong> {{ table.primaryKey }}</p>
        </v-card-text>
        <v-card-actions v-if="!pdfUrl">
          <v-btn color="primary" @click="downloadPdf( table.id )" :loading="loading">
            <v-icon left>mdi-download</v-icon> Baixar PDF
          </v-btn>
        </v-card-actions>

       

        <!-- Exibe um link para abrir o PDF após o primeiro download -->
        <v-card-text v-if="pdfUrl">
          <v-alert type="success" class="mt-4">
            <v-icon left>mdi-file</v-icon>
            <a :href="pdfUrl" target="_blank" rel="noopener noreferrer">
              Abrir PDF: {{ fileName }}
            </a>
          </v-alert>
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
    },
    data(){
      return{
        pdfUrl: null,
        fileName: null
      }
    },
    methods:{
      async downloadPdf(tableId){

        //this.loading = true;
        try {
          const { fileName, url } = await tableService.getTablePdf(tableId);
          
          this.pdfUrl = url; // Salva o link do PDF
          this.fileName = fileName;
          window.open(url, '_blank'); // Abre em uma nova aba

        } catch (err) {
          //this.error = "Erro ao baixar o PDF.";
        } finally {
         // this.loading = false;
        }
      }
    }
  };
  </script>
  