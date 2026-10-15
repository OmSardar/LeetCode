param(
    [Parameter(Mandatory = $true)]
    [string]$SourceFile
)

$ErrorActionPreference = "Stop"

if (-not (Test-Path -LiteralPath $SourceFile -PathType Leaf)) {
    Write-Error "Java source file does not exist: $SourceFile"
    exit 1
}

$SourceFile = (Resolve-Path -LiteralPath $SourceFile).Path
$SourceDirectory = Split-Path -Parent $SourceFile
$OutputDirectory = Join-Path $SourceDirectory ".java-build"
$SourceText = Get-Content -LiteralPath $SourceFile -Raw
$PackageMatch = [regex]::Match(
    $SourceText,
    '(?m)^\s*package\s+([A-Za-z_$][A-Za-z0-9_$]*(?:\.[A-Za-z_$][A-Za-z0-9_$]*)*)\s*;'
)
$ClassMatch = [regex]::Match(
    $SourceText,
    '(?m)^\s*public\s+(?:(?:abstract|final|sealed|non-sealed)\s+)*class\s+([A-Za-z_$][A-Za-z0-9_$]*)\b'
)
$MainClass = if ($ClassMatch.Success) {
    $ClassMatch.Groups[1].Value
} else {
    [IO.Path]::GetFileNameWithoutExtension($SourceFile)
}

if ($PackageMatch.Success) {
    $MainClass = "$($PackageMatch.Groups[1].Value).$MainClass"
}

if (Test-Path -LiteralPath $OutputDirectory) {
    Remove-Item -LiteralPath $OutputDirectory -Recurse -Force
}

New-Item -ItemType Directory -Path $OutputDirectory -Force | Out-Null

& javac -encoding UTF-8 -d $OutputDirectory $SourceFile
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

& java -cp $OutputDirectory $MainClass
exit $LASTEXITCODE
