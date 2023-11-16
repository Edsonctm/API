import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appFundoAzul]'
})
export class FundoAzulDirective {

  @HostListener('mouseenter') onMouseOver(){
    this.bk = 'black'
  }

  @HostListener('mouseleave') onMouseOut(){
    this.bk = 'white'
  }

  @HostBinding("style.backgroundColor") get color(){
    if (this.bk == 'white'){
      this.bk = 'blue'
    }
    return this.bk
  }
  private bk: string | undefined

  constructor(private _elementRef: ElementRef, private _renderer: Renderer2) {
  }

}
