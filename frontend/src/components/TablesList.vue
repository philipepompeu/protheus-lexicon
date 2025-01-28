<template>
    <v-container>
      <v-row>
        <v-col v-if="loading" cols="12" class="text-center">
          <v-progress-circular indeterminate color="primary"></v-progress-circular>
          Carregando tabelas...
        </v-col>
        <v-col v-else cols="12">
          <v-data-table
            :headers="headers"
            :items="tables"
            item-value="id"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Tabelas do Protheus</v-toolbar-title>
              </v-toolbar>
            </template>
  
            <template v-slot:[`item.id`]="{ item }">
              <v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <v-chip v-bind="attrs" v-on="on" color="primary" text-color="white">
                    {{ item.id }}
                  </v-chip>
                </template>
                <span>ID da Tabela: {{ item.id }}</span>
              </v-tooltip>
            </template>
  
            <template v-slot:[`item.primaryKey`]="{ item }">
              <span>{{ item.primaryKey }}</span>
            </template>
  
          </v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import { tableService } from '../services/tableService';
  
  export default {
    name: 'TablesList',
    data() {
      return {
        tables: [],
        loading: true,
        headers: [
          { text: 'ID', align: 'start', key: 'id', sortable: true },
          { text: 'Descrição', value: 'description', sortable: true },
          { text: 'Chave Primária', value: 'primaryKey' },
        ],
      };
    },
    mounted() {
      this.fetchTables();
    },
    methods: {
      async fetchTables() {
        try {
          this.tables = await tableService.getTables();
        } catch (error) {
          console.error('Erro ao carregar tabelas:', error);
        } finally {
          this.loading = false;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .v-tooltip__content {
    max-width: 200px;
  }
  </style>
  