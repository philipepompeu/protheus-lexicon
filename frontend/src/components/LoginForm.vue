<template>
    <v-container class="login-container">
      <v-card class="pa-7" max-width="400">
        <v-card-title>Login</v-card-title>
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
  
            <v-btn type="submit" color="primary" block>Entrar</v-btn>
          </v-form>
        </v-card-text>
        <v-alert v-if="errorMessage" type="error">{{ errorMessage }}</v-alert>
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
          this.errorMessage = 'Usu�rio ou senha incorretos!';
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
  