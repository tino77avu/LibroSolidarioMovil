package com.example.librosolidario;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.PopupMenu;

public final class NavigationMenuHelper {
    private static final int MENU_INICIO = 1;
    private static final int MENU_EXPLORAR = 2;
    private static final int MENU_COMPARTIR = 3;
    private static final int MENU_IMPACTO = 4;
    private static final int MENU_PERFIL = 5;
    private static final int MENU_MI_PANEL = 6;

    private NavigationMenuHelper() {
    }

    public static void show(Activity activity, View anchor) {
        PopupMenu popupMenu = new PopupMenu(activity, anchor);
        Menu menu = popupMenu.getMenu();
        menu.add(Menu.NONE, MENU_INICIO, Menu.NONE, "Inicio");
        menu.add(Menu.NONE, MENU_EXPLORAR, Menu.NONE, "Explorar");
        menu.add(Menu.NONE, MENU_COMPARTIR, Menu.NONE, "Compartir libro");
        menu.add(Menu.NONE, MENU_IMPACTO, Menu.NONE, "Impacto");
        menu.add(Menu.NONE, MENU_PERFIL, Menu.NONE, "Perfil");
        menu.add(Menu.NONE, MENU_MI_PANEL, Menu.NONE, "Mi panel");

        popupMenu.setOnMenuItemClickListener(item -> {
            Intent intent = null;
            Class<?> targetClass = null;
            int itemId = item.getItemId();
            if (itemId == MENU_INICIO) {
                targetClass = InicioActivity.class;
            } else if (itemId == MENU_EXPLORAR) {
                targetClass = ExplorarActivity.class;
            } else if (itemId == MENU_COMPARTIR) {
                targetClass = CompartirLibroActivity.class;
            } else if (itemId == MENU_IMPACTO) {
                targetClass = ImpactoActivity.class;
            } else if (itemId == MENU_PERFIL) {
                targetClass = PerfilActivity.class;
            } else if (itemId == MENU_MI_PANEL) {
                targetClass = MiPanelActivity.class;
            }

            if (targetClass != null && !activity.getClass().equals(targetClass)) {
                intent = new Intent(activity, targetClass);
                activity.startActivity(intent);
            }
            return true;
        });
        popupMenu.show();
    }
}
