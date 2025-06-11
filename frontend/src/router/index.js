import { createRouter, createWebHashHistory } from 'vue-router';
import TablesList from '@/components/TablesList.vue';
import ParametersList from '@/components/ParametersList.vue';
import QuestionsList from '@/components/QuestionsList.vue';
import TableDetails from '@/components/TableDetails.vue';
import LoginForm from '@/components/LoginForm.vue';
import DatabaseConfigForm from '@/components/DatabaseConfigForm.vue';
import AuthService from '@/services/AuthService';

const routes = [ 
  {
    path: '/tables/:tableId',
    name: 'TableDetails',
    component: TableDetails, // Página com os campos da tabela selecionada
    props: true, // Permite que o parâmetro `tableId` seja passado como prop para o componente
    meta: { requiresAuth: true } 
  },
  { path: '/configure'  , component: DatabaseConfigForm,meta: { requiresAuth: true }  },
  { path: '/questions'  , component: QuestionsList,meta: { requiresAuth: true }       },
  { path: '/parameters' , component: ParametersList,meta: { requiresAuth: true }      },
  { path: '/login'      , component: LoginForm},
  {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: () => import('@/components/NotFound.vue'),
  },
  {
    path: '/',
    name: 'TablesList',
    component: TablesList, // Página inicial com a lista de tabelas
    meta: { requiresAuth: true } 
  },
];


const router = createRouter({
  history: createWebHashHistory(),
  routes
});

// Middleware para verificar autenticação antes de acessar rotas protegidas
router.beforeEach((to, from, next) => {
  const isAuthenticated = AuthService.isAuthenticated();

  if (to.meta.requiresAuth && !isAuthenticated) {
    next('/login'); // Redireciona para login se não estiver autenticado
  } else {
    next(); // Permite acessar a rota normalmente
  }
});

export default router;
