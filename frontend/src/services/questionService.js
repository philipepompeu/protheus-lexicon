import api from './apiService';

const questionService = {
  async getQuestions(page = 0, size = 10, sort = 'description,asc', filterByName="") {
    try {      
      const response = await api.get('/questions', { params: { page, size, sort , name:filterByName } });
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar parâmetros:', error);
      throw error;
    }
  },
  
  async getQuestionByName(name) {
    const response = await api.get(`questions/${name}`);
    return response.data;
  }
  
};

export default questionService;
