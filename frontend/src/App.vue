<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title>Protheus Lexicon</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <v-container>
        <TablesList />
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import TablesList from './components/TablesList';

export default {
  name: "App",
  components: {
    TablesList,
  },
};
</script>
