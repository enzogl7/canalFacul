/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
      './src/main/resources/templates/**/*.html',
      './src/main/resources/static/**/*.js',
  ],
  theme: {
    extend: {
        colors: {
            'blue-button': '#3D5A80',
        }
    },
  },
  plugins: [],
}

