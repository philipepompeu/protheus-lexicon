// src/services/apiService.js
import axios from 'axios';
import { API_URL } from '@/config';
import AuthService from '@/services/AuthService';
import { ref } from 'vue';

// Criar um estado global para erro da API
export const apiError = ref(null);

const api = axios.create({
  baseURL: API_URL,
  timeout: 5000 // Define um tempo limite para requisiушes
});

// Interceptor para adicionar o token JWT nas requisições
api.interceptors.request.use(
  (config) => {
    const token = AuthService.getToken();
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => Promise.reject(error)
);

// Add a response interceptor
api.interceptors.response.use(function (response) {
  // Any status code that lie within the range of 2xx cause this function to trigger
  // Do something with response data
  return response;
}, function (error) {
  
  if (error.response && (error.response.status == 401 ||  error.response.status == 403 )) {
    
    AuthService.logout();
  }
  return Promise.reject(error);
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
