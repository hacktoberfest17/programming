class Hex {
  constructor(hex) {
    this.hex = hex;
  }
  
  toRgb() {
    let hex = this.hex;
    
    return {
      r: parseInt(hex.slice(1, 3), 16),
      g: parseInt(hex.slice(3, 5), 16),
      b: parseInt(hex.slice(5, 7), 16)
    };
  }
}
