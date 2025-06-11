<template>
    <v-container class="login-container">
      <v-card class="pa-6 d-flex justify-center align-center h-screen" max-width="500" width="100%" elevation="4">
        <v-card-title class="justify-center align-center position-relative">Login</v-card-title>
        <v-card-text>
          <v-form @submit.prevent="login">
            <v-text-field
              v-model="username"
              label="Usuário"
              required
            ></v-text-field>
  
            <v-text-field
              v-model="password"
              label="Senha"
              type="password"
              required
            ></v-text-field>
  
            <v-btn type="submit" color="primary" block prepend-icon="mdi-login" size="large">Entrar</v-btn>
            <v-btn type="" variant="plain" color="secundary" block>Cadastrar</v-btn>
          </v-form>
        </v-card-text>
        <v-card-text>
          <v-alert v-if="errorMessage" type="error" variant="elevated" closable>{{ errorMessage }}</v-alert>
        </v-card-text>
        
      </v-card>
    </v-container>
  </template>
  
  <script>
  import AuthService from '@/services/AuthService';
  import { useRouter } from 'vue-router';
  
  export default {
    data() {
      return {
        username: '',
        password: '',
        errorMessage: ''
      };
    },
    setup() {
      const router = useRouter();
      return { router };
    },
    methods: {
      async login() {
        const token = await AuthService.login(this.username, this.password);
        if (token) {
          this.router.push('/'); // Redireciona para a tela inicial
        } else {
          this.errorMessage = 'Usuário ou senha incorretos!';
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  </style>
  