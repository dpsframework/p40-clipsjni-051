#include "bug.h"

#include "utility.h"
#include "generate.h"
#include "envrnmnt.h"
#include "expressn.h"
#include "extnfunc.h"
#include "objrtmch.h"
#include "rulebld.h"


/*******************************************/
/* CONSTRUCT IMAGE INITIALIZATION FUNCTION */
/*******************************************/

void *InitCImage_1()
  {
   static void *theEnv = NULL;

   if (theEnv != NULL) return(NULL);

   theEnv = CreateRuntimeEnvironment(sht1,fht1,iht1,bmht1);

   EnvClear(theEnv);
   RefreshSpecialSymbols(theEnv);
   InstallFunctionList(theEnv,P1_1);

   InitExpressionPointers(theEnv);
   FixupCImage_1(theEnv);

   SetListOfDefmodules(theEnv,(void *) U_1_1);
   EnvSetCurrentModule(theEnv,(void *) EnvGetNextDefmodule(theEnv,NULL));

   SetObjectNetworkPointer(theEnv,NULL);
   SetObjectNetworkTerminalPointer(theEnv,NULL);

   ObjectsRunTimeInitialize(theEnv,N_1_1,M_1_1,O_1_1,P_1);

   DeftemplateRunTimeInitialize(theEnv);

   ResetDefglobals(theEnv);

   DefruleRunTimeInitialize(theEnv,NULL,NULL);

   return(theEnv);
  }
