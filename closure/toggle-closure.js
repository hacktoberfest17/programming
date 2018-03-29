/*
 * Initialize a toggle with a given boolean state.
 * Returns an object which will contain the toggle's current state, and a function to change it.
 * Usage:
 * > let initState = false;
 * > let state = initToggle(initState);
 * > state().current  // current state (in this case, "false")
 * > state().change() // flips state, returns new state (in this case, "true")
 */
function initToggle(state) {
    if (typeof state !== "boolean") throw "input is not a boolean";
    let _state = state;
    return () => ({
        current: Boolean(_state), 
      change: () => Boolean(_state ^= 1)
    });
  }