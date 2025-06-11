<template>
  <v-container>
    <v-card class="pa-4">
      <v-card-title>Configurar Conexão com o Banco</v-card-title>
      <v-card-text>
        <v-form @submit.prevent="saveConfig">
          <v-text-field 
            v-model="config.host" 
            label="Endereço IP" 
            required 
            v-mask="'###.###.###.###'"
          ></v-text-field>
          <v-text-field 
            v-model.number="config.port" 
            label="Porta" 
            required 
            type="number"
            min="1" 
            max="65535"
          ></v-text-field>
          <v-text-field v-model="config.database" label="Nome do Banco" required></v-text-field>
          <v-text-field v-model="config.user" label="Usuário" required></v-text-field>
          <v-text-field v-model="config.password" label="Senha" type="password" required></v-text-field>
          <v-btn color="primary" type="submit">Salvar</v-btn>
        </v-form>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import ConfigureService from '@/services/ConfigureService';
import { mask } from 'vue-the-mask';

export default {
  directives: { mask },
  data() {
    return {
      config: {
        host: '',
        port: '',
        database: '',
        user: '',
        password: ''
      }
    };
  },
  methods: {
    async saveConfig() {
      if (!this.config.host || !this.config.port || !this.config.database || !this.config.user || !this.config.password) {
        alert('Todos os campos são obrigatórios!');
        return;
      }
      try {
        const response = await ConfigureService.saveConfig(this.config);
        console.log('Configuração salva:', response.data);
        alert('Configuração salva com sucesso!');
      } catch (error) {
        console.error('Erro ao salvar configuração:', error);
        alert('Erro ao salvar configuração. Verifique os dados e tente novamente.');
      }
    }
  }
};
</script>
