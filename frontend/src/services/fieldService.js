export const fieldService = {
    async getFields(tableId) {
      // Simula um delay para carregar os dados (ex.: chamada de API)
      console.log(tableId);
      return new Promise((resolve) => {
        setTimeout(() => {
          resolve([
            {
              field: "CN9_FILIAL",
              type: "C",
              size: 8,
              decimal: 0,
              title: "Filial",
              description: "Filial do Sistema",
              valid: "",
              init: "",
              when: "",
            },
            {
              field: "CN9_NUMERO",
              type: "C",
              size: 8,
              decimal: 0,
              title: "Número",
              description: "Número do Contrato",
              valid: "",
              init: "",
              when: "",
            },
          ]);
        }, 500); // Simula 500ms de delay
      });
    },
  };
  