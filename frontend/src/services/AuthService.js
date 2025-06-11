import api from '@/services/apiService'; // Usa o Axios centralizado

const AuthService = {
  async login(username, password) {
    try {
      const response = await api.post('/auth/login', { username, password });
      
      if (response && response.data.token) {
        localStorage.setItem('jwt_token', response.data.token); // Armazena o token
        return response.data.token;
      }
      return null;
    } catch (error) {
      console.error('Erro ao autenticar:', error);
      return null;
    }
  },
  
  async signIn(username, password) {
    try {
      const response = await api.post('/auth/register', { username, password });
      
      if (response && response.data.token) {
        localStorage.setItem('jwt_token', response.data.token); // Armazena o token
        return response.data.token;
      }
      return null;
    } catch (error) {
      console.error('Erro ao autenticar:', error);
      return null;
    }
  },

  logout() {
    localStorage.removeItem('jwt_token'); // Remove o token ao fazer logout
  },

  getToken() {
    return localStorage.getItem('jwt_token'); // Obtém o token do cache
  },

  isAuthenticated() {
    return !!this.getToken(); // Retorna true se o usuário estiver autenticado
  }
};

export default AuthService;
