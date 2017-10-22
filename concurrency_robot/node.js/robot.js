'use strict';

// Node.js is async. Using event-driven programming is a good choice
const EventEmitter = require('events');
const event = new EventEmitter();

// Left
event.on('left', () => {
  console.log('left');
  event.emit('right');
});

// Right
event.on('right', () => {
  console.log('right');
  event.emit('left');
});

// Do first step
event.emit('left');
