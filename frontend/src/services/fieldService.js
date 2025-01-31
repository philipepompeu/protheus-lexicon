import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080'; // Atualize se necessário

const fieldService = {
  async getFields(tableId) {
    try {
      const response = await axios.get(`${API_BASE_URL}/tables/${tableId}/fields`);
      return response.data; // Retorna os campos da tabela específica
    } catch (error) {
      console.error('Erro ao buscar os campos da tabela:', error);
      throw error;
    }
  }
};

export default fieldService;
