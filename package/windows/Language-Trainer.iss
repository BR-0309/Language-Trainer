;This file will be executed next to the application bundle image
;I.e. current directory will contain folder Language-Trainer with application files
[Setup]
AppId={{Language_Trainer_id}}
AppName=Language Trainer
AppVersion=0.6.5
AppVerName=Language Trainer 0.6.5
AppPublisher=Benjamin Raison
AppComments=Language Trainer
AppCopyright=Copyright (C) 2015
;AppPublisherURL=http://java.com/
;AppSupportURL=http://java.com/
;AppUpdatesURL=http://java.com/
DefaultDirName={localappdata}\Language-Trainer
DisableStartupPrompt=Yes
DisableDirPage=auto
DisableProgramGroupPage=Yes
DisableReadyPage=No
DisableFinishedPage=No
DisableWelcomePage=No
DefaultGroupName=Benjamin Raison
;Optional License
LicenseFile=
;WinXP or above
MinVersion=0,5.1 
OutputBaseFilename=Language-Trainer-0.6.5
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=Language-Trainer\Language-Trainer.ico
UninstallDisplayIcon={app}\Language-Trainer.ico
UninstallDisplayName=Language-Trainer
WizardImageStretch=No
WizardSmallImageFile=Language-Trainer-setup-icon.bmp   
ArchitecturesInstallIn64BitMode=x64


[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Files]
Source: "Language-Trainer\Language-Trainer.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "Language-Trainer\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\Language Trainer"; Filename: "{app}\Language-Trainer.exe"; IconFilename: "{app}\Language-Trainer.ico"; Check: returnTrue()
Name: "{commondesktop}\Language Trainer"; Filename: "{app}\Language-Trainer.exe";  IconFilename: "{app}\Language-Trainer.ico"; Check: returnTrue()


[Run]
Filename: "{app}\Language-Trainer.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\Language-Trainer.exe"; Description: "{cm:LaunchProgram,Language-Trainer}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\Language-Trainer.exe"; Parameters: "-install -svcName ""Language-Trainer"" -svcDesc ""Practice Languages"" -mainExe ""Language-Trainer.exe""  "; Check: returnFalse()

[UninstallRun]
Filename: "{app}\Language-Trainer.exe "; Parameters: "-uninstall -svcName Language-Trainer -stopOnUninstall"; Check: returnFalse()

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;  
