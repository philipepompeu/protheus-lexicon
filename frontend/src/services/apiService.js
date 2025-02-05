// src/services/apiService.js
import axios from 'axios';
import { API_URL } from '@/config';

const api = axios.create({
  baseURL: API_URL,
  timeout: 5000 // Define um tempo limite para requisições
});

// Interceptor para capturar erros e tratar quando a API estiver offline
api.interceptors.response.use(
  response => response,
  error => {
    if (!error.response) {
      console.error('Erro: API offline ou inacessível');
      throw new Error('A API está offline. Tente novamente mais tarde.');
    }
    return Promise.reject(error);
  }
);

export default api;
