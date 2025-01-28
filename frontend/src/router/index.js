import { createRouter, createWebHistory } from 'vue-router';
import TablesList from '@/components/TablesList.vue';
import TableFields from '@/components/TableFields.vue';

const routes = [
  {
    path: '/',
    name: 'TablesList',
    component: TablesList, // P�gina inicial com a lista de tabelas
  },
  {
    path: '/fields/:tableId',
    name: 'TableFields',
    component: TableFields, // P�gina com os campos da tabela selecionada
    props: true, // Permite que o par�metro `tableId` seja passado como prop para o componente
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
