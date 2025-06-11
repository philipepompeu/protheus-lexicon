import api from './apiService';

const tableService = {
  async getTables(page = 0, size = 10, sort = 'description,asc', filterById="") {
    try {      
      const response = await api.get('/tables', { params: { page, size, sort , id:filterById } });
      return response.data;
    } catch (error) {
      console.error('Erro ao buscar tabelas:', error);
      throw error;
    }
  },
  
  async getTableById(tableId) {
    const response = await api.get(`tables/${tableId}`);
    return response.data;
  },

  async getTableIndexes(tableId){
    const response = await api.get(`tables/${tableId}/indexes`);
    return response.data;
  },
  
  async getTablePdf(tableId){
    const response = await api.get(`tables/${tableId}/pdf`);
    return response.data;
  }
};

export default tableService;
