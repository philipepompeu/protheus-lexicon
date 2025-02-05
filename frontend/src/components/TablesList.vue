<template>
    <v-container>
      <v-row>
        <v-col v-if="loading" cols="12" class="text-center">
          <v-progress-circular indeterminate color="primary"></v-progress-circular>
          Carregando tabelas...
        </v-col>
        <v-col v-else cols="12">
          <v-data-table-server
            v-model:items-per-page="itemsPerPage"
            :search="filterById"
            :items-length="totalItems"
            :headers="headers"
            :items="tables"
            :loading="loading"
            @update:options="fetchTables"
            item-value="id"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Tabelas do Protheus</v-toolbar-title>
              </v-toolbar>
            </template>
  
            <template v-slot:[`item.id`]="{ item }">
              <router-link :to="`/tables/${item.id}`" class="text-decoration-none">

                <v-chip color="primary" text-color="white">
                  {{ item.id }}
                </v-chip>
                <!--<v-btn text>{{ item.id }}</v-btn>-->
              </router-link>
              
              <!--<v-tooltip bottom>
                <template v-slot:activator="{ on, attrs }">
                  <v-chip v-bind="attrs" v-on="on" color="primary" text-color="white">
                    {{ item.id }}
                  </v-chip>
                </template>
                <span>ID da Tabela: {{ item.id }}</span>
              </v-tooltip>-->
            </template>
  
            <template v-slot:[`item.primaryKey`]="{ item }">
              <span>{{ item.primaryKey }}</span>
            </template>

            <template v-slot:tfoot>
              <tr>
                <td>
                  <v-text-field v-model="filterById" class="ma-2" density="compact" placeholder="Buscar tabela..." hide-details></v-text-field>
                </td>                
              </tr>
            </template>
  
          </v-data-table-server>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import  tableService from '../services/tableService';
  
  export default {
    name: 'TablesList',
    data() {
      return {
        tables: [],
        loading: true,
        totalItems: 0,
        //page:0,
        itemsPerPage: 10,
        headers: [
          { title: 'ID', align: 'start', key: 'id', sortable: true },
          { title: 'Descrição', key: 'description', sortable: true },
          { title: 'Chave Primária', key: 'primaryKey' },
        ],
        filterById: ''
      };
    },
    mounted() {
      
      this.fetchTables({page:1, itemsPerPage:10});
    },
    methods: {
      async fetchTables({ page, itemsPerPage }) {
        try {          
          
          const response = await tableService.getTables(page - 1, itemsPerPage, null,this.filterById);
          this.tables = response.content;          
          this.totalItems = response.totalElements;
        } catch (error) {
          console.error('Erro ao carregar tabelas:', error);
          this.$emit('error', error);
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
  