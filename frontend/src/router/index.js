import { createRouter, createWebHistory } from 'vue-router';
import TablesList from '@/components/TablesList.vue';
import ParametersList from '@/components/ParametersList.vue';
import QuestionsList from '@/components/QuestionsList.vue';
import TableDetails from '@/components/TableDetails.vue';
import DatabaseConfigForm from '@/components/DatabaseConfigForm.vue';

const routes = [ 
  {
    path: '/tables/:tableId',
    name: 'TableDetails',
    component: TableDetails, // Página com os campos da tabela selecionada
    props: true, // Permite que o parâmetro `tableId` seja passado como prop para o componente
  },
  { path: '/configure'  , component: DatabaseConfigForm },
  { path: '/questions'  , component: QuestionsList      },
  { path: '/parameters' , component: ParametersList     },
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
