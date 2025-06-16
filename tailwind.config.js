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
            'primary-bg': '#0F111A',
            'text-primary': '#F2F4F8',
            'text-secondary': '#A6ADBA',
            'accent': '#4FD1C5',
            'button': '#3D5A80',
            'error': '#E57373',
            'success': '#2EC4B6'
        }
    },
  },
  plugins: [],
}

