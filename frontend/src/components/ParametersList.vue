<template>
    <v-container>
      <v-row>
        <v-col v-if="loading" cols="12" class="text-center">
          <v-progress-circular indeterminate color="primary"></v-progress-circular>
          Carregando parâmetros...
        </v-col>
        <v-col v-else cols="12">
          <v-data-table-server
            v-model:items-per-page="itemsPerPage"
            :search="filterByName"
            :items-length="totalItems"
            :headers="headers"
            :items="parameters"
            :loading="loading"
            @update:options="fetchParameters"
            item-value="id"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Parâmetros</v-toolbar-title>
              </v-toolbar>
            </template>
  
            <template v-slot:[`item.name`]="{ item }">
              <router-link :to="`/parameters/${item.name}`" class="text-decoration-none">
                <v-chip color="primary" text-color="white">
                  {{ item.name }}
                </v-chip>                
              </router-link>              
             
            </template>
  
            <template v-slot:[`item.primaryKey`]="{ item }">
              <span>{{ item.primaryKey }}</span>
            </template>

            <template v-slot:tfoot>
              <tr>
                <td>
                  <v-text-field v-model="filterByName" class="ma-2" density="compact" placeholder="Buscar tabela..." hide-details></v-text-field>
                </td>                
              </tr>
            </template>
  
          </v-data-table-server>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import  parameterService from '../services/parameterService';
  
  export default {
    name: 'ParametersList',
    data() {
      return {
        parameters: [],
        loading: true,
        totalItems: 0,
        //page:0,
        itemsPerPage: 10,
        headers: [
          { title: 'Nome', align: 'start', key: 'name', sortable: true },
          { title: 'Descrição', key: 'description', sortable: true },
          { title: 'Valor', key: 'value' },
          { title: 'Tipo', key: 'type' },
          { title: 'Valor padrão', key: 'defaultValue' }
        ],
        filterByName: ''
      };
    },
    mounted() {
      
      this.fetchParameters({page:1, itemsPerPage:10});
    },
    methods: {
      async fetchParameters({ page, itemsPerPage }) {
        try {          
          
          const response = await parameterService.getParameters(page - 1, itemsPerPage, null,this.filterByName);
          this.parameters = response.content;          
          this.totalItems = response.totalElements;
        } catch (error) {
          console.error('Erro ao carregar parametros:', error);
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
  