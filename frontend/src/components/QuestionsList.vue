<template>
    <v-container>
      <v-row>
        <v-col v-if="loading" cols="12" class="text-center">
          <v-progress-circular indeterminate color="primary"></v-progress-circular>
          Carregando perguntas...
        </v-col>
        <v-col v-else cols="12">
          <v-data-table-server
            v-model:items-per-page="itemsPerPage"
            :search="filterByName"
            :items-length="totalItems"
            :headers="headers"
            :items="questions"
            :loading="loading"
            @update:options="fetchQuestions"
            item-value="id"
            class="elevation-1"
          >
            <template v-slot:top>
              <v-toolbar flat>
                <v-toolbar-title>Perguntas(SX1)</v-toolbar-title>
              </v-toolbar>
            </template>
  
            <template v-slot:[`item.name`]="{ item }">
                <v-list lines="one" density="compact">
                    <v-list-item
                        v-for="question in item.items"
                        :key="`${question.id}`"
                        :title="`${question.sequence}`"
                        :subtitle= "`${question.questionText}`"
                    ></v-list-item>
                </v-list>
              <!--<router-link :to="`/questions/${item.name}`" class="text-decoration-none">


                <v-chip color="primary" text-color="white">
                  {{ item.name }}
                </v-chip>                
              </router-link> -->             
             
            </template>
  
            <!--template v-slot:[`item.primaryKey`]="{ item }">
              <span>{{ item.primaryKey }}</span>
            </template>-->

            <template v-slot:tfoot>
              <tr>
                <td>
                  <v-text-field v-model="filterByName" class="ma-2" density="compact" placeholder="Buscar grupo..." hide-details></v-text-field>
                </td>                
              </tr>
            </template>
  
          </v-data-table-server>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import  questionService from '../services/questionService';
  
  export default {
    name: 'questionsList',
    data() {
      return {
        questions: [],
        loading: true,
        totalItems: 0,
        //page:0,
        itemsPerPage: 10,
        headers: [
          { title: 'Nome', align: 'start', key: 'name', sortable: true }
        ],
        filterByName: ''
      };
    },
    mounted() {
      
      this.fetchQuestions({page:1, itemsPerPage:10});
    },
    methods: {
      async fetchQuestions({ page, itemsPerPage }) {
        try {          
          
          const response = await questionService.getQuestions(page - 1, itemsPerPage, null,this.filterByName);
          this.questions = response.content;          
          this.totalItems = response.totalElements;
        } catch (error) {
          console.error('Erro ao carregar perguntes:', error);
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
  