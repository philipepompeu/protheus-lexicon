<template>
    <v-container class="login-container">
      <v-card class="pa-6 d-flex justify-center align-center h-screen" max-width="500" width="100%" elevation="4">
        <v-card-title>Cadastrar usuário</v-card-title>
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
            
            <v-text-field
              v-model="passwordValidation"
              label="Confirme a senha"
              type="password"
              required
            ></v-text-field>
  
            <v-btn type="submit" color="primary" block prepend-icon="mdi-login">Cadastrar</v-btn>
          </v-form>
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
        const token = await AuthService.signIn(this.username, this.password);
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
  