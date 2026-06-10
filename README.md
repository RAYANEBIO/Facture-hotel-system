# 🏨 Facture Hotel System

Un système de gestion de facturation pour hôtel développé en C++. Ce projet permet de gérer les clients, les chambres, les séjours et la génération automatique des factures.

## 📋 Présentation

Facture Hotel System est une application console conçue pour simplifier la gestion administrative d'un hôtel. Elle automatise le calcul des frais liés aux réservations et génère des factures détaillées pour chaque client.

## ✨ Fonctionnalités

- Enregistrement des clients
- Gestion des chambres
- Réservation de chambres
- Calcul automatique du montant du séjour
- Génération de factures
- Affichage des informations clients
- Historique des réservations
- Interface en ligne de commande simple et intuitive

## 🛠️ Technologies utilisées

- C++
- Programmation Orientée Objet (POO)
- Fichiers source séparés (.cpp / .h)
- Gestion dynamique des données

## 📂 Structure du projet

```text
Facture-hotel-system/
│
├── main.cpp
├── include/
│   ├── Client.h
│   ├── Chambre.h
│   ├── Facture.h
│   └── Hotel.h
│
├── src/
│   ├── Client.cpp
│   ├── Chambre.cpp
│   ├── Facture.cpp
│   └── Hotel.cpp
│
└── README.md
```

## 🚀 Compilation

### Avec g++

```bash
g++ *.cpp -o HotelSystem
```

### Exécution

```bash
./HotelSystem
```

## 💡 Exemple de scénario

1. Création d'un client.
2. Attribution d'une chambre.
3. Calcul automatique du coût du séjour.
4. Génération de la facture.
5. Affichage du montant total à payer.

### Exemple

```text
Nom du client : John Doe
Numéro de chambre : 205
Nombre de nuits : 4
Prix par nuit : 35000 FCFA

Montant total : 140000 FCFA
```

## 🎯 Objectifs pédagogiques

Ce projet permet de pratiquer :

- La programmation orientée objet en C++
- L'encapsulation des données
- Les constructeurs et destructeurs
- Les classes et objets
- L'organisation d'un projet logiciel
- La gestion d'un système de facturation

## 🔮 Améliorations futures

- Sauvegarde des données dans des fichiers
- Base de données MySQL
- Interface graphique Qt
- Gestion des employés
- Statistiques et rapports
- Export PDF des factures

## 👨‍💻 Auteur

**Rayane BIO**

Étudiant en informatique passionné par le développement logiciel, les systèmes de gestion et la programmation orientée objet.

## 📄 Licence

Projet réalisé à des fins pédagogiques et d'apprentissage.
