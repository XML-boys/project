import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Home',
    icon: 'home-outline',
    link: '/agent',
    home: true,
  },
  {
    title: 'ADS',
    group: true,
  },
  {
    title: 'My ads',
    icon: 'pricetags',
    link: '/agent/my-ads',
    home: false,
  },
  {
    title: 'New ad',
    icon: 'plus-circle',
    link: '/agent/new-ad',
    home: false,
  },
  {
    title: 'Vehicles',
    group: true,
  },
  {
    title: 'Add vehicle',
    icon: 'car',
    link: '/agent/new-vehicle',
    home: false,
  },
];
