<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Protheus Lexicon</v-toolbar-title>
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
