import axios from 'axios';

const API_URL = 'http://localhost:8080/tables';

const tableService = {
  async getTables(page = 0, size = 10, sort = 'description,asc') {
    try {
      const response = await axios.get(API_URL, { params: { page, size, sort } });
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar tabelas:', error);
      throw error;
    }
  }
};

export default tableService;
