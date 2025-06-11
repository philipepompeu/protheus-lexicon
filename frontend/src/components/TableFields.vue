<template>
    <v-container>
      <v-row>
        <v-col cols="12">
          <v-toolbar flat>
            <v-toolbar-title>Campos da Tabela: {{ tableId }}</v-toolbar-title>
          </v-toolbar>
        </v-col>
      </v-row>
      <v-row>
        <v-col cols="12" v-if="loading" class="text-center">
          <v-progress-circular indeterminate color="primary"></v-progress-circular>
          Carregando campos...
        </v-col>
        <v-col cols="12" v-else>
          <v-data-table
            :headers="headers"
            :items="fields"
            class="elevation-1"
          >
          </v-data-table>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  import fieldService  from "../services/fieldService";
  
  export default {
    name: "TableFields",
    props: {
      tableId: {
        type: String,
        required: true,
      },
    },
    data() {
      return {
        loading: true, // Indicador de carregamento
        fields: [], // Dados dos campos
        headers: [
          { title: "Campo", key: "field" },
          { title: "Tipo", key: "type" },
          { title: "Tamanho", key: "size" },
          { title: "Decimais", key: "decimal" },
          { title: "Título", key: "title" },
          { title: "Descrição", key: "description" },
          { title: "Validação", key: "valid" },
          { title: "Inicialização", key: "init" },
          { title: "Condição", key: "when" },
        ],
      };
    },
    mounted() {
      console.log('Componente TableFields montado');
      this.fetchFields();
    },
    setup(props) {
      console.log('Table ID recebido:', props.tableId);
    },
    watch: {tableId: "fetchFields"},
    methods: {
      async fetchFields() {
        try {
          // Busca os dados do mock service
          this.fields = await fieldService.getFields(this.tableId);
        } catch (error) {
          console.error("Erro ao carregar os campos:", error);
          this.$emit('error', error);
        } finally {
          this.loading = false; // Conclui o carregamento
        }
      },
    },
  };
  </script>
  