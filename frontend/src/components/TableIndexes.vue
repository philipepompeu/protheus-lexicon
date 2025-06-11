<template>
    <v-container>
      <v-card>
        <v-card-title>Índices da Tabela</v-card-title>
        <v-card-text>
          <v-list v-if="indexes.length">
            <v-list-item v-for="index in indexes" :key="index.id">
              <v-list-item-content>
                <v-list-item-title>{{ index.sequence }} - {{ index.description }}</v-list-item-title>
                <v-list-item-subtitle>{{ index.key }}</v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
          </v-list>
          <v-alert v-else type="info">Nenhum índice encontrado.</v-alert>
        </v-card-text>
      </v-card>
    </v-container>
  </template>
  
  <script>
  import tableService from '@/services/tableService';
  
  export default {
    props: {
      tableId: {
        type: String,
        required: true
      }
    },
    data() {
      return {
        indexes: []
      };
    },
    async mounted() {
      await this.fetchIndexes();
    },
    methods: {
      async fetchIndexes() {
        try {
          this.indexes = await tableService.getTableIndexes(this.tableId);
        } catch (error) {
          console.error('Erro ao buscar índices:', error);
          this.$emit('error', error);
        }
      }
    }
  };
  </script>
  