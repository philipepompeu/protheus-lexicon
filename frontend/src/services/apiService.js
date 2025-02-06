// src/services/apiService.js
import axios from 'axios';
import { API_URL } from '@/config';
import { ref } from 'vue';

// Criar um estado global para erro da API
export const apiError = ref(null);

const api = axios.create({
  baseURL: API_URL,
  timeout: 5000 // Define um tempo limite para requisiушes
});

// Interceptor para capturar erros e tratar quando a API estiver offline
api.interceptors.response.use(
  response => response,
  error => {
    console.log(error);
    apiError.value = 'Erro ao conectar à API. Verifique se o servidor está online.';
    return Promise.resolve(null); // Retorna null ao invés de propagar erro
  }
);

export default api;
