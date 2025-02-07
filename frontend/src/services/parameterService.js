import api from './apiService';

const parameterService = {
  async getParameters(page = 0, size = 10, sort = 'description,asc', filterByName="") {
    try {      
      const response = await api.get('/parameters', { params: { page, size, sort , name:filterByName } });
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar parâmetros:', error);
      throw error;
    }
  },
  
  async getParameterByName(name) {
    const response = await api.get(`parameters/${name}`);
    return response.data;
  }
  
};

export default parameterService;
