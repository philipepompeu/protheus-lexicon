class ConfigureService {
    static async saveConfig(config) {
      return new Promise((resolve) => {
        console.log('Configuração recebida:', config);
        setTimeout(() => {
          resolve({ data: 'Configuração salva com sucesso!' });
        }, 500);
      });
    }
  }
  
  export default ConfigureService;
  