<script setup>
  import { apiError } from '@/services/apiService';
</script>

<template>
  <v-app>
    <v-toolbar app color="primary" dark>
      <v-toolbar-title>
        <router-link to="/" class="text-decoration-none text-white">Protheus Lexicon</router-link>
      </v-toolbar-title>
      
      <v-spacer></v-spacer>

      <v-btn text to="/">Tabelas (SX3)</v-btn>
      <v-btn text to="/parameters">Parâmetros (SX6)</v-btn>
      <v-btn text to="/questions">Perguntas (SX1)</v-btn>
    </v-toolbar>

    <v-main>
      <v-container>
        <!-- Alerta de erro global da API -->
        <v-alert
          v-if="apiError"
          type="error"
          dense dismissible
          closable
          @click:close="apiError = null"
        >
          {{ apiError }}
        </v-alert>

        <RouterView />
      </v-container>
    </v-main>
    <!-- Rodapé -->
    <v-footer app class="bg-grey-lighten-3 text-center">
      <v-container>
        <v-row justify="center">
          <v-col cols="12">
            <span>© {{ new Date().getFullYear() }} - Protheus Lexicon</span> |
            <a href="http://localhost:8080/swagger-ui.html" target="_blank">Documentação da API (Swagger)</a>
          </v-col>
        </v-row>
      </v-container>
    </v-footer>
  </v-app>
</template>

<script>

export default {
  name: "App",
  components: {
    
  },
  data() {
    return {
      errorMessage: ''
    };
  },
  methods: {
    handleError(error) {
      this.errorMessage = error.message;
    }
  }
};
</script>
