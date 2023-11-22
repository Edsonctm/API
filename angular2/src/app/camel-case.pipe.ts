import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase',
  pure: false
})
export class CamelCasePipe implements PipeTransform {

  transform(value: string[], ...args: unknown[]): string[] {
    let result: string[] = []

    value.forEach((v) => {
      let x = v[0].toUpperCase() + v.substring(1).toLowerCase()
      result.push(x)
    })
    return result;
  }

}
