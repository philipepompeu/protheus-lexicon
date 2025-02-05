
import api from './apiService';

const fieldService = {
  async getFields(tableId) {
    try {
      const response = await api.get(`/tables/${tableId}/fields`);
      return response.data; // Retorna os campos da tabela específica
    } catch (error) {
      console.error('Erro ao buscar os campos da tabela:', error);
      throw error;
    }
  }
};

export default fieldService;
