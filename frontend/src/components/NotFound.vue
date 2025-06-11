<template>
    <v-container>
      <v-row>
        <v-col cols="12" class="text-center">
          <v-icon large>mdi-alert-circle</v-icon>
          <h1>Página Não Encontrada</h1>
          <p>Desculpe, a página que você procurou não existe ou não foi encontrada.</p>
          <v-btn color="primary" @click="goHome">Voltar para a página inicial</v-btn>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
  export default {
    name: "NotFound",
    methods: {
      goHome() {
        this.$router.push('/'); // Navega de volta para a página inicial
      },
    },
  };
  </script>
  
  <style scoped>
  .text-center {
    text-align: center;
  }
  </style>
  