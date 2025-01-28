import { createApp } from 'vue'
import App from './App.vue'
import router from './router'; // Importa o roteador
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'

loadFonts()

createApp(App)
  .use(router) // Usa o roteador
  .use(vuetify)
  .mount('#app')
