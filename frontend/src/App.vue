<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title><router-link :to="`/`" class="text-decoration-none">Protheus Lexicon</router-link></v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container>        
        <RouterView />
      </v-container>
    </v-main>
    <!-- Rodap� -->
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
};
</script>
