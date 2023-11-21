import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase'
})
export class CamelCasePipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): string {
    let values = value.split(' ')
    let result = ''

    values.forEach((v) => {
      let x = v[0].toUpperCase() + v.substring(1).toLowerCase()
      result += x + " "
    })
    return result;
  }

}
