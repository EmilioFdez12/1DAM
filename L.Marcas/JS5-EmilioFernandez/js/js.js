// Escucha click en el enlace "anchor" en <a></a>
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
  anchor.addEventListener('click', function (e) {
    // previene que haga la accion default de los enlaces(que vaya directamente al enlace)
    e.preventDefault();

    let targetId = this.getAttribute('href').substring(1); // Obtenemos el ID del elemento de destino eliminando el '#'
    let targetElement = document.getElementById(targetId);

    // Animacion
    if (targetElement) {
      window.scrollTo({
        top: targetElement.offsetTop,
        behavior: 'smooth' // Aplicamos un desplazamiento suave
      });
    }
  });
});


// Carousel manual
document.addEventListener('DOMContentLoaded', () => {
  const inner = document.querySelector('.carousel-inner');
  const prev = document.querySelector('.carousel-prev');
  const next = document.querySelector('.carousel-next');
  const imgWidth = document.querySelector('.carousel-inner img').clientWidth; // Obtenemos el ancho de la imagen

  let currentIndex = 0;

  // Listener para el botón prev
  prev.addEventListener('click', (event) => {
    event.preventDefault();
    currentIndex = Math.max(currentIndex - 1, 0); // Aseguramos que currentIndex no sea menor que cero
    inner.style.transform = `translateX(-${currentIndex * imgWidth}px)`; // Movemos el carrusel hacia la izquierda
  });

  // Listener para el botón siguiente
  next.addEventListener('click', (event) => {
    event.preventDefault();
    currentIndex = (currentIndex + 1) % inner.childElementCount; // Avanzamos al siguiente índice o volvemos al primero
    inner.style.transform = `translateX(-${currentIndex * imgWidth}px)`; // Movemos el carrusel hacia la derecha
  });
});

// Carousel con Reproductor
document.addEventListener('DOMContentLoaded', () => {
  const inner = document.querySelector('.carousel-inner');
  const play = document.querySelector('#reanudar');
  const stop = document.querySelector('#parar');
  // Obtenemos el ancho de la imagen
  const imgWidth = document.querySelector('.carousel-inner img').clientWidth; 
  // Obtenemos el número total de imágenes
  const totalImages = inner.querySelectorAll('.fotos').length; 

  let currentIndex = 0;
  let timer;

  // Listener para el botón de reproducción
  play.addEventListener('click', (event) => {
    event.preventDefault();
     // Inicia la reproducción automática
    autoplay();
  });

  // Listener para el botón de pausa
  stop.addEventListener('click', (event) => {
    event.preventDefault();
    // Detiene la reproducción automática
    clearTimeout(timer); 
  });

  // Función para iniciar la reproducción automática
  function autoplay() {
    // Reinicia el índice a cero
    currentIndex = 0; 
    // Muestra la siguiente imagen
    showNextImage(); 
  }

  // Función para mostrar la siguiente imagen
  function showNextImage() {
    if (currentIndex >= totalImages) {
      // Detiene la reproducción si se alcanza la última imagen
      clearTimeout(timer); 
      return;
    }

    // Calcula el valor de traslación para la animación
    const translateValue = -currentIndex * imgWidth; 
    // Aplica la animación
    inner.style.transform = `translateX(${translateValue}px)`; 
    currentIndex++; 

     // Tiempo entre imagen e imagen
    timer = setTimeout(showNextImage, 1500);
  }
});

// Función para activar/desactivar el modo oscuro
function toggleDarkMode() {
  const body = document.body;
  // Alterna la clase para el modo oscuro en el body
  body.classList.toggle("body-darkmode"); 

  // Guarda el estado del modo oscuro en una "cookie"
  localStorage.setItem('darkMode', body.classList.contains("body-darkmode"));

  // Aplica o elimina los estilos del modo oscuro según corresponda
  if (body.classList.contains("body-darkmode")) {
    applyDarkModeStyles();
  } else {
    removeDarkModeStyles();
  }
}

// Aplica los estilos del modo oscuro
function applyDarkModeStyles() {
  // Selecciona los elementos y les añade las clases para el modo oscuro
  let botonSvg = document.getElementById('botonSvg');
  let botonSvg2 = document.getElementById('botonSvg2');
  let carousel = document.querySelector('.carousel');
  let prev = document.querySelector('.carousel-prev');
  let next = document.querySelector('.carousel-next');
  let cuadro = document.querySelector('.cuadroReproductor');

  botonSvg.classList.add("dark-input");
  botonSvg2.classList.add("dark-input");
  carousel.classList.add("dark-borderFoto");
  prev.classList.add("dark-nextPrev");
  next.classList.add("dark-nextPrev");
  cuadro.classList.add("dark-reproductor");
}

// Elimina los estilos del modo oscuro
function removeDarkModeStyles() {
  // Selecciona los elementos y elimina las clases del modo oscuro
  let botonSvg = document.getElementById('botonSvg');
  let botonSvg2 = document.getElementById('botonSvg2');
  let carousel = document.querySelector('.carousel');
  let prev = document.querySelector('.carousel-prev');
  let next = document.querySelector('.carousel-next');
  let cuadro = document.querySelector('.cuadroReproductor');

  botonSvg.classList.remove("dark-input");
  botonSvg2.classList.remove("dark-input");
  carousel.classList.remove("dark-borderFoto");
  prev.classList.remove("dark-nextPrev");
  next.classList.remove("dark-nextPrev");
  cuadro.classList.remove("dark-reproductor");
}

// Función para inicializar el modo oscuro al cargar la página
document.addEventListener("DOMContentLoaded", function () {
  const darkModeToggle = document.getElementById('darkModeToggle');

  // Obtiene el estado del modo oscuro de la cookie
  const isDarkMode = localStorage.getItem('darkMode') === 'true';

  // Actualiza el boton del modo oscuro según el estado actual
  darkModeToggle.checked = isDarkMode;

  // Aplica el modo oscuro si estaba activado
  if (isDarkMode) {
    toggleDarkMode();
  }
});

// Función llamada cuando se hace clic en el interruptor de modo oscuro
function modoOscuroActivacion() {
  // Activa o desactiva el modo oscuro
  toggleDarkMode(); 
}
