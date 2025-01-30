<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title><router-link :to="`/`" class="text-decoration-none">Protheus Lexicon</router-link></v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container>        
        <RouterView />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: "App",
  components: {
    
  },
};
</script>
