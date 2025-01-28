import { createRouter, createWebHistory } from 'vue-router';
import TablesList from '@/components/TablesList.vue';
import TableFields from '@/components/TableFields.vue';

const routes = [ 
  {
    path: '/fields/:tableId',
    name: 'TableFields',
    component: TableFields, // Página com os campos da tabela selecionada
    props: true, // Permite que o parâmetro `tableId` seja passado como prop para o componente
  },
  {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: () => import('@/components/NotFound.vue'),
  },
  {
    path: '/',
    name: 'TablesList',
    component: TablesList, // Página inicial com a lista de tabelas
  },
];


const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
