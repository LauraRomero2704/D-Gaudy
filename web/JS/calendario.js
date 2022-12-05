
/* CALENDARIO ACOMPAÑADO */
const isLeapYear = (year) => {
    return (
      (year % 4 === 0 && year % 100 !== 0 && year % 400 !== 0) ||
      (year % 100 === 0 && year % 400 === 0)
    );
  };
  const getFebDays = (year) => {
    return isLeapYear(year) ? 29 : 28;
  };
  let calendario = document.querySelector('.calendario');
  const nombreMeses = [
    'Enero',
    'Febrero',
    'Marzo',
    'Abril',
    'Mayo',
    'Junio',
    'Julio',
    'Agosto',
    'Septiembre',
    'Octubre',
    'Noviembre',
    'Diciembre',
  ];
  let selectorMeses = document.querySelector('#selector_meses');
  const formatoTextoDia = document.querySelector('.formato_texto_dia');
  const formatoTiempo = document.querySelector('.formato_tiempo');
  const formatoFecha = document.querySelector('.formato_fecha');
  
  selectorMeses.onclick = () => {
    listaMeses.classList.remove('ocultar1');
    listaMeses.classList.remove('ocultar');
    listaMeses.classList.add('mostrar');
    formatoTextoDia.classList.remove('funcion_tiempo');
    formatoTextoDia.classList.add('ocultarTiempo');
    formatoTiempo.classList.remove('funcion_tiempo');
    formatoTiempo.classList.add('ocultarTiempo');
    formatoFecha.classList.remove('funcion_tiempo');
    formatoFecha.classList.add('ocultarTiempo');
  };
  
  const generateCalendario = (month, year) => {
    let diasCalendario = document.querySelector('.dias_calendario');
    diasCalendario.innerHTML = '';
    let añoCabecera = document.querySelector('#año');
    let diasMes = [
      31,
      getFebDays(year),
      31,
      30,
      31,
      30,
      31,
      31,
      30,
      31,
      30,
      31,
    ];
    
    let fechaActual = new Date();
    
    selectorMeses.innerHTML = nombreMeses[month];
    
    añoCabecera.innerHTML = year;
    
    let primerDia = new Date(year, month);
  
  
  for (let i = 0; i <= diasMes[month] + primerDia.getDay() - 1; i++) {
  
      let day = document.createElement('div');
  
      if (i >= primerDia.getDay()) {
        day.innerHTML = i - primerDia.getDay() + 1;

        if (i - primerDia.getDay() + 1 === fechaActual.getDate() &&
          year === fechaActual.getFullYear() &&
          month === fechaActual.getMonth()
        ) {
          day.classList.add('fecha_actual');
        }
      }
      diasCalendario.appendChild(day);
    }
  };
  
  let listaMeses = calendario.querySelector('.lista_meses');
  nombreMeses.forEach((e, index) => {
    let month = document.createElement('div');
    month.innerHTML = `<div>${e}</div>`;
  
    listaMeses.append(month);
    month.onclick = () => {
      mesActual.value = index;
      generateCalendario(mesActual.value, añoActual.value);
      listaMeses.classList.replace('mostrar', 'ocultar');
      formatoTextoDia.classList.remove('ocultarTiempo');
      formatoTextoDia.classList.add('funcion_tiempo');
      formatoTiempo.classList.remove('ocultarTiempo');
      formatoTiempo.classList.add('funcion_tiempo');
      formatoFecha.classList.remove('ocultarTiempo');
      formatoFecha.classList.add('funcion_tiempo');
    };
  });
  
  (function () {
    listaMeses.classList.add('ocultar1');
  })();
  document.querySelector('#año_anterior').onclick = () => {
    --añoActual.value;
    generateCalendario(mesActual.value, añoActual.value);
  };
  document.querySelector('#proximo_año').onclick = () => {
    ++añoActual.value;
    generateCalendario(mesActual.value, añoActual.value);
  };
  
  let fechaActual = new Date();
  let mesActual = { value: fechaActual.getMonth() };
  let añoActual = { value: fechaActual.getFullYear() };
  generateCalendario(mesActual.value, añoActual.value);

  const horaActual = document.querySelector('.formato_tiempo');
  const fechaDiaActual = document.querySelector('.formato_fecha');
  
  const presentacionFechaActual = new Date();
  const presentacionHoraActual = {
    year: 'numeric',
    month: 'long',
    day: 'numeric',
    weekday: 'long',
  };
  const formatoFechaActual = new Intl.DateTimeFormat(
    'ES',
    presentacionHoraActual
  ).format(presentacionFechaActual);
  fechaDiaActual.textContent = formatoFechaActual;
  setInterval(() => {
    const temporizador = new Date();
    const opcion = {
      hour: 'numeric',
      minute: 'numeric',
      second: 'numeric',
    };
    const formatoTemporizador = new Intl.DateTimeFormat('es', opcion).format(temporizador);
    let tiempo = `${`${temporizador.getHours()}`.padStart(
      2,
      '0'
    )}:${`${temporizador.getMinutes()}`.padStart(
      2,
      '0'
    )}: ${`${temporizador.getSeconds()}`.padStart(2, '0')}`;
    horaActual.textContent = formatoTemporizador;
  }, 1000);
  