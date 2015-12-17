DELETE FROM TEAM_PLAYER;
DELETE FROM Player;
DELETE FROM Team;

INSERT INTO Team (idTeam, dateOfEstablishment, name, region) VALUES (1, '2011-01-01', 'TSM', 'NA')
INSERT INTO Team (idTeam, dateOfEstablishment, name, region) VALUES (2, '2011-06-18', 'Fnatic', 'EU')
INSERT INTO Team (idTeam, dateOfEstablishment, name, region) VALUES (3, '2014-01-01', 'Roccat', 'PL')

INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (1, 'Wildturtle', false, 'Jason', 'AD', 'Tran', 1)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (2, 'Bjergsen', false, 'Soren', 'Mid', 'Bjerg', 1)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (3, 'Santorin', true, 'Lucas', 'Jungle', 'Larsen', 1)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (4, 'Dyrus', true, 'Marcus', 'Top', 'Hill', 1)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (5, 'Lustboy', true, 'Jang-Sik', 'Support', 'Ham', 1)

INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (6, 'Huni', false, 'Heo', 'Top', 'Seung-hoon', 2)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (7, 'Reignover', false, 'Kim', 'Jungle', 'Ui-jin', 2)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (8, 'Febiven', false, 'Fabian', 'Mid', 'Diepstraten', 2)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (9, 'Rekkles', false, 'Martin', 'AD', 'Larsson', 2)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (10, 'YellOwStaR', false, 'Bora', 'Support', 'Kim', 2)

INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (11, 'Steve', false, 'Etienne', 'Top', 'Michels', 3)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (12, 'Jankos', false, 'Marcin', 'Jungle', 'Jankowski', 3)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (13, 'Nukeduck', false, 'Erlend', 'Mid', 'Holm', 3)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (14, 'MrRalleZ', false, 'Rasmus', 'AD', 'Skinneholm', 3)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (15, 'VandeR', false, 'Oskar', 'Support', 'Bogdan', 3)
INSERT INTO Player (idPlayer, ign, isRetired, name, role, surname, team_idTeam) VALUES (16, 'YamatoCannon', false, 'Jakob', 'Coach', 'Mebdi', 3)

INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (1, 1)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (1, 2)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (1, 3)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (1, 4)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (1, 5)

INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (2, 6)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (2, 7)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (2, 8)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (2, 9)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (2, 10)

INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 11)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 12)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 13)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 14)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 15)
INSERT INTO TEAM_PLAYER(TEAM_IDTEAM, PLAYERS_IDPLAYER) VALUES (3, 16)
