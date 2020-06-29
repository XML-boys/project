import { NbMenuItem } from '@nebular/theme';

export const MENU_ITEMS: NbMenuItem[] = [
  {
    title: 'Home',
    icon: 'home-outline',
    link: '/agent/dashboard',
    home: true,
  },
  {
    title: 'ADS',
    group: true,
  },
  {
    title: 'My ads',
    icon: 'pricetags',
    link: '/agent/dashboard/my-ads',
    home: false,
  },
  {
    title: 'New ad',
    icon: 'plus-circle',
    link: '/agent/dashboard/new-ad',
    home: false,
  },
  {
    title: 'Reservations',
    icon: 'pricetags',
    link: '/agent/dashboard/reservations',
    home: false,
  },
  {
    title: 'Vehicles',
    group: true,
  },
  {
    title: 'Add vehicle',
    icon: 'car',
    link: '/agent/dashboard/new-vehicle',
    home: false,
  },
];
