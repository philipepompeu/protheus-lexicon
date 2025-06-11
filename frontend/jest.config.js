module.exports = {  
  testEnvironment: "jsdom",
  moduleFileExtensions: ["js", "json", "vue"],
  transform: {
    "^.+\\.vue$": "@vue/vue3-jest",
    "^.+\\.js$": "babel-jest"
  },
  transformIgnorePatterns: ["/node_modules/(?!axios)"],
  moduleNameMapper: {
    "^@/(.*)$": "<rootDir>/src/$1", // Resolve os imports com '@/'
    "\\.(css|less|scss|sass)$": "jest-transform-stub" // Evita erro com import de CSS
  },
  collectCoverage: true,
  collectCoverageFrom: ["src/**/*.{js,vue}", "!**/node_modules/**"],
};