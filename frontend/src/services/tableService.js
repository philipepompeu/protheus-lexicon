export const tableService = {
    // Mock para simular a resposta da API
    getTables() {
      return new Promise((resolve) => {
        setTimeout(() => {
          resolve([
            { id: 'CN9', description: 'Contratos', primaryKey: 'CN9_FILIAL+CN9_NUMERO+CN9_REVISA' },
            { id: 'CNA', description: 'Planilhas', primaryKey: 'CNA_FILIAL+CNA_CONTRA+CNA_REVISA+CNA_NUMERO' }
            // Adicione outras tabelas conforme necessário
          ]);
        }, 1000); // Simula um delay de 1 segundo (como se fosse uma requisição)
      });
    },
  };
  